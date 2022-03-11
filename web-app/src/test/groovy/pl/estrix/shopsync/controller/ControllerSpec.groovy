package pl.estrix.shopsync.controller

import org.springframework.lang.Nullable
import org.springframework.ui.Model
import spock.lang.Specification

class ControllerSpec extends Specification {

    protected static Model createDefaultModel() {
        Model model = new Model() {
            @Override
            Model addAttribute(String s, @Nullable Object o) {
                return null
            }

            @Override
            Model addAttribute(Object o) {
                return null
            }

            @Override
            Model addAllAttributes(Collection<?> collection) {
                return null
            }

            @Override
            Model addAllAttributes(Map<String, ?> map) {
                return null
            }

            @Override
            Model mergeAttributes(Map<String, ?> map) {
                return null
            }

            @Override
            boolean containsAttribute(String s) {
                return false
            }

            @Override
            Map<String, Object> asMap() {
                return null
            }
        }
        model
    }
}
