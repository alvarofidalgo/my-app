describe('controller to automatic responses',function(){

var controller,view,store,dataResponse;
    

    beforeEach(function(){
       view = sinon.stub();
       view['cleanErrors'] = sinon.spy();
       view['showError'] = sinon.spy();
       view['clearResumeTransactions'] = sinon.spy();
       view['showResumeTransaction']= sinon.spy();
       dataResponse = [{currencyFrom:'anyCurrency',
                        currencyTo : 'currencyTo',
                        otherFormatDate:'24-10:27:44'
                    }]
    })


	it (' When exist errors show this',function(){
        store = new Double_store([],["aaa","bbb"]);
        Controller(view,store).runWith({});
        expect(view.cleanErrors).to.be.called;
        expect(view.showError).to.be.calledWith("aaa");
        expect(view.showError).to.be.calledWith("bbb");

	});

	it (' when exist resumes show this',function(){
        store = new Double_store(dataResponse,[]);
        Controller(view,store).runWith({});
        expect(view.clearResumeTransactions).to.be.called;
        expect(view.showResumeTransaction).to.be.calledWith(dataResponse.pop());
	});



})