describe('model of automatica aplication',function(){

var resumeTrasaction,callbackPrint,callbackRestore;

    beforeEach(function(){
    	callbackRestore= sinon.stub();
    	callbackPrint = sinon.stub();
        resumeTrasaction= ResumeTransaction(callbackRestore,callbackPrint);
        callback= sinon.stub();

    });

    it(' when exist data in store',function(){
         resumeTrasaction.forEach(["aa","bb"]);
         expect(callbackRestore).have.been.called;
         expect(callbackPrint).have.been.calledWith("aa");
         expect(callbackPrint).have.been.calledWith("bb");
    });

    it (' when no exist data in store',function(){
    	 resumeTrasaction.forEach([]);
         expect(callbackRestore).have.not.been.called;
         expect(callbackPrint).have.not.been.called;
         expect(callbackPrint).have.not.been.called;
    })
})