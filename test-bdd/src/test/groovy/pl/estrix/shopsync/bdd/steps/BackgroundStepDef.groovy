package pl.estrix.shopsync.bdd.steps

import pl.estrix.shopsync.bdd.loader.FileLoader
import pl.estrix.shopsync.bdd.request.OSRequestSender

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~/^configured tenant$/) { ->
    // Write code here that turns the phrase above into concrete actions
    fileLoader = new FileLoader()
    osSender = new OSRequestSender()
}