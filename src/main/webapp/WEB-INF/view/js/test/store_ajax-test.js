
describe (' Simple ajax ',function(){

 var store,callback;
     
     beforeEach(function(){
     	store = new Store();
      callback = sinon.stub();
 
     });

     afterEach(function () {
      $.ajax.restore();
    });

     it (' when status is OK',function(){
     	var data = [{currencyFrom:'anyCurrency',
      				currencyTo:'anyCurrency',
      				otherFormatDate:'24-10:27:44'}];
          stubing_correct_status('success',data);
          store.insertTransaction({},callback)
          expect(callback).have.been.calledWith(data);
     });

     it ( ' when status is not modified ',function(){
     	  stubing_correct_status('notmodified');
     	  store.insertTransaction({},callback)
     	  expect(callback).have.not.been.called;
     });

    it (' when recovery errors ',function(){
      var data = ["ERROR1","ERROR2"];
          stubing_correct_status('success',data);
          store.errorsInTransaction({},callback)
          expect(callback).have.been.calledWith(data);
     })

});