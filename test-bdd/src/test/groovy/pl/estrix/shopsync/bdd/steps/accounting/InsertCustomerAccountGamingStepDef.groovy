package pl.estrix.shopsync.bdd.steps.accounting

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

def requestBody
def receivedCallId
def responseCode
def endpoint = "accounting"

Given(~/^Create accounting endpoint connection$/) { ->
    def request = fileLoader.loadRequestAsString("insert/01-sample.xml")
    request = request.replace("?", UUID.randomUUID().toString())
    requestBody = request
}

When(~/^I send customerAccountGaming POST request$/) { ->
    osSender.insertRecord(endpoint, requestBody)
}