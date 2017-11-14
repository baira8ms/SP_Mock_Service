# SP_Mock_Service

## Tariff Change:

* Sample post request: http://localhost:8080/sp/tariff_change/add
  * json-data: {"canumber":"1000","quoteId":"100","referenceId":"101","error":"STD","selectedProduct":"Scottish Power","timestamp":"2017-11-22","channel":"New","currentProduct":"Good"}
 
 ** Timestamps query end-point : http://localhost:8080/sp/tariff_change/timestamps

## Account details:

* Sample post request: http://localhost:8080/sp/account_details/add
  * json-data: {"accountBalance":"1000","directDebitAmt":"100","meterReadingType":"STD","nextMeterReadingDate":"2017-11-22T12:34:56.123456789Z","paymentPlan":"New","service":"Good"}


