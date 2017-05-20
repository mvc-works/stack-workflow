
require('respo-ui');
require('./main.css');

var main = require('shadow-cljs/client.main.js');

if (module.hot) {
  module.hot.accept('shadow-cljs/client.main.js', function() {
    main = require('shadow-cljs/client.main.js');
    main.on_jsload_BANG_();
  });
}
