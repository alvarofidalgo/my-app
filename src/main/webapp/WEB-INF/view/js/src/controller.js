"use strict"
function Controller(view,store){
	var modelError = ResumeTransaction(view.cleanErrors,view.showError),
	    modelResume = ResumeTransaction(view.clearResumeTransactions,view.showResumeTransaction);

	return {runWith:function(transaction){
               store.errorsInTransaction(transaction,modelError.forEach);
               store.insertTransaction(transaction,modelResume.forEach);
           }
    }
}