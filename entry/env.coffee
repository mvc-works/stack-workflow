
fs = require 'fs'
path = require 'path'

config = require '../shadow-cljs.json'

if process.env.target is 'nodejs'
  config['source-paths'] = ['polyfill', 'src']
else
  config['source-paths'] = ['src']

pkg = require '../package.json'

pkg['shadow-cljs'] = config

fs.writeFileSync path.join(__dirname, '../package.json'), JSON.stringify(pkg, null, 2)
console.log 'Rewrote package.json'
