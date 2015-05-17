
describe(' generator transaction objects to send',function(){

	it ('when call first second time',function(){
          var  generator = jsonToSendGenerator();
               expect(generator.buildJSON()['userId']).to.be.equal("134256");
               expect(generator.buildJSON()['userId']).to.be.equal("");
               expect(generator.buildJSON()['currencyFrom']).to.be.equal("EUR");
               expect(generator.buildJSON()['currencyFrom']).to.be.equal("");


	})

})