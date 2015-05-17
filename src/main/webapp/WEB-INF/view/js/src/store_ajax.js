"use strict"
function Store(){

}
function _success(callback){
   return function (data, status_param){
          data = data || [];
		  if(status_param == 'success') 
		      callback(data);	
   }
}

Store.prototype.insertTransaction = function(data,callback){
	                        return $.ajax({
		                                 url: '/transactions/insertTransaction',
		                                 type: 'POST',
		                                 contentType: 'application/json',
		                                 data: JSON.stringify(data),
		                                 success: _success(callback)
		                            });
	    }

Store.prototype.errorsInTransaction = function(data,callback){

	                        return $.ajax({
		                                 url: '/transactions/errors',
		                                 type: 'GET',
		                                 contentType: 'application/json',
		                                 data: $.param(data),
		                                 success: _success(callback)
		                            });
     }



