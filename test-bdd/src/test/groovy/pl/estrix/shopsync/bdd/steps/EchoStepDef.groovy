package pl.estrix.shopsync.bdd.steps

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

def requestBody
def receivedCallId
def responseCode
def endpoint = "version"

Given(~/^Create endpoint connection$/) { ->
    def request = fileLoader.loadRequestAsString("insert/00-call-version.json")
//    request = request.replace("?", UUID.randomUUID().toString())
    requestBody = request
}

When(~/^I send POST request$/) { ->
    osSender.insertRecord(endpoint, requestBody)
}

Then(~/^The result status code is (\d+)$/) { int statusCode ->
    responseCode = osSender.getResponseCode()
    assert statusCode == responseCode
}

And(~/^Response call Id is not null$/) { ->
    receivedCallId = osSender.getReceivedCallId()
    assert receivedCallId != null
}