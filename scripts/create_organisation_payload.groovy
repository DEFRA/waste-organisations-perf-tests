// Get variables from JMeter system properties
String threadNum = ctx.getThreadNum().toString()

// JSON payload as string with interpolation
String postPayload = """{
  "name" : "England Ltd ${threadNum}",
  "tradingName" : "Trading Name",
  "businessCountry" : "GB-ENG",
  "companiesHouseNumber" : "12345678",
  "address" : {
    "addressLine1" : "England Ltd",
    "addressLine2" : "123 Street",
    "town" : "Town",
    "county" : "County",
    "postcode" : "UK1",
    "country" : "UK"
  },
  "registration" : {
    "status" : "REGISTERED",
    "type" : "SMALL_PRODUCER",
    "registrationYear" : 2025
  }
}"""

// Set the payload variable
vars.put("postPayload", postPayload)
