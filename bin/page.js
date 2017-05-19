
var main = require('shadow-cljs/client.main.js');

window.onload = main._main_BANG_;

if (module.hot) {
  module.hot.accept('shadow-cljs/client.main.js', function() {
    main = require('shadow-cljs/client.main.js');
    main.on_jsload_BANG_();
  });
}
