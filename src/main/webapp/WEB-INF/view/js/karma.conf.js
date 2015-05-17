// Karma configuration
// Generated on Fri May 01 2015 23:19:52 GMT+0200 (CEST)

module.exports = function(config) {
  config.set({

    // base path that will be used to resolve all patterns (eg. files, exclude)
    basePath: '',


    // frameworks to use
    // available frameworks: https://npmjs.org/browse/keyword/karma-adapter
    frameworks: ['mocha','chai','sinon'],


    // list of files / patterns to load in the browser
    files: [ 
       'node_modules/sinon-chai/lib/sinon-chai.js',
       'node_modules/sinon-chai/lib/sinon-chai.js',
       'node_modules/underscore/underscore.js',
       'node_modules/chai-fuzzy/index.js', 
       './vendor/jQuery.js',
       './src/resumes_view.js',
       './src/resume_trasaction.js',
       './src/store_ajax.js',
       './src/controller.js',
       './test/ajax_stubs.js',
       './test/double_store.js',
       './test/store_ajax-test.js', 
       './test/resume_transaction-test.js',
       './test/controller-test.js',
    ],


    // list of files to exclude
    exclude: [
    ],


    // preprocess matching files before serving them to the browser
    // available preprocessors: https://npmjs.org/browse/keyword/karma-preprocessor
    preprocessors: {
    },


    // test results reporter to use
    // possible values: 'dots', 'progress'
    // available reporters: https://npmjs.org/browse/keyword/karma-reporter
    reporters: ['progress'],


    // web server port
    port: 9876,


    // enable / disable colors in the output (reporters and logs)
    colors: true,


    // level of logging
    // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
    logLevel: config.LOG_INFO,


    // enable / disable watching file and executing tests whenever any file changes
    autoWatch: true,


    // start these browsers
    // available browser launchers: https://npmjs.org/browse/keyword/karma-launcher
    browsers: ['PhantomJS'],


    // Continuous Integration mode
    // if true, Karma captures browsers, runs the tests and exits
    singleRun: false
  });
};
