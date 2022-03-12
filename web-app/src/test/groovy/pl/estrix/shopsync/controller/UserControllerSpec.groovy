package pl.estrix.shopsync.controller


import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import pl.estrix.shopsync.model.UserDto
import pl.estrix.shopsync.model.UserPasswordDto
import pl.estrix.shopsync.service.impl.UserServiceImpl
import pl.estrix.shopsync.tool.EStringUtils
import pl.estrix.shopsync.tool.UserUtil

class UserControllerSpec extends ControllerSpec {

    def userService = Mock(UserServiceImpl)
    def userUtil = Mock(UserUtil)
    def standardPasswordEncoder = Mock(PasswordEncoder)
    def bindingResult = Mock(BindingResult);
    def userController = new UserController(userService, userUtil, standardPasswordEncoder)

    def "should show UserController index page"() {
        given:
        Model model = createDefaultModel()

        when:
        def page = userController.user(model)

        then:
        page == "user/index"
    }

    def "should show UserController form page"() {
        when:
        def page = userController.add()

        then:
        page == "user/userform"
    }

    def "should invoke UserController checkInfo page with validate error"() {
        given:
        UserDto userDto = createDefaultUserDto();
        1 * bindingResult.hasErrors() >> true

        when:
        def page = userController.checkInfo(userDto,bindingResult)

        then:
        page == "user/userform"
    }

    def "should invoke UserController checkInfo page with no error"() {
        given:
        UserDto userDto = createDefaultUserDto();

        when:
        def page = userController.checkInfo(userDto,bindingResult)

        then:
        page == "redirect:/user/"
    }

    def "should invoke UserController edit page with no error"() {
        given:
        Model model = createDefaultModel()
        def hashId = EStringUtils.DEFAULT_MOCK + "_1"

        when:
        def page = userController.edit(hashId,model)

        then:
        page == "user/userform"
    }


    def "should invoke UserController delete page"() {
        given:
        Model model = createDefaultModel()

        when:
        def page = userController.delete(1,model)

        then:
        page == "redirect:/user/"
    }

    def "should invoke UserController change password page"() {
        given:
        Model model = createDefaultModel()
        UserPasswordDto userPasswordDto = createDefaultUserPasswordDto()
//        1 * SecurityContextHolder.getContext().getAuthentication() >> prepareAuthentication()

        when:
        def page = userController.changePasswordForm(userPasswordDto,model)

        then:
        page == "user/changepassword"
    }

    def "should invoke UserController save password page"() {
        given:
        Model model = createDefaultModel()
        UserPasswordDto userPasswordDto = createDefaultUserPasswordDto()
        1 * userService.getByLogin(_) >> createDefaultUserDto()
        1 * standardPasswordEncoder.matches(_,_) >> true

        when:
        def page = userController.changePasswordCheck(userPasswordDto,bindingResult,model)

        then:
        page == "redirect:/user/"
    }
    def "should invoke UserController save password error1 "() {
        given:
        Model model = createDefaultModel()
        UserPasswordDto userPasswordDto = createDefaultUserPasswordDto()
        1 * userService.getByLogin(_) >> createDefaultUserDto()
        1 * standardPasswordEncoder.matches(_,_) >> false
        1 * bindingResult.hasErrors() >> true

        when:
        def page = userController.changePasswordCheck(userPasswordDto,bindingResult,model)

        then:
        page == "user/changepassword"
    }

    def "should invoke UserController save password error2 "() {
        given:
        Model model = createDefaultModel()
        UserPasswordDto userPasswordDto = createDefaultUserPasswordDto()
        userPasswordDto.setRepeatPassword("different")
        1 * userService.getByLogin(_) >> createDefaultUserDto()
        1 * standardPasswordEncoder.matches(_,_) >> true
        1 * bindingResult.hasErrors() >> true

        when:
        def page = userController.changePasswordCheck(userPasswordDto,bindingResult,model)

        then:
        page == "user/changepassword"
    }

    private static Authentication prepareAuthentication(){
        Authentication authentication = new Authentication() {
            @Override
            Collection<? extends GrantedAuthority> getAuthorities() {
                return null
            }

            @Override
            Object getCredentials() {
                return null
            }

            @Override
            Object getDetails() {
                return null
            }

            @Override
            Object getPrincipal() {
                return null
            }

            @Override
            boolean isAuthenticated() {
                return false
            }

            @Override
            void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

            }

            @Override
            String getName() {
                return null
            }
        }
        authentication
    }

    private static UserPasswordDto createDefaultUserPasswordDto(){
        UserPasswordDto
                .builder()
                .newPassword("newPassword")
                .repeatPassword("newPassword")
                .oldPassword("Password")
                .build()
    }

    private static UserDto createDefaultUserDto() {
        UserDto userDto = new UserDto()
        userDto.setEmail("email")
        userDto.setUserName(null)
        userDto.setUserLastname("UserLastname")
        userDto.setPassword("Password")
        userDto.setRole("ROLE_USER")
        userDto.setEnabled(true)
        userDto.setLocked(false)

        userDto
    }

}
