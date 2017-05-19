
path = require 'path'
{resolve} = require 'path'
webpack = require 'webpack'

module.exports =
  entry:
    style: 'respo-ui'
    main: './bin/page.js'
  devServer:
    hot: true
    contentBase: resolve(__dirname, 'target')
    publicPath: '/'
  output:
    path: path.join __dirname, '../target/'
    filename: '[name].js'
  module:
    rules: [
      test: /\.css$/, loaders: ['style-loader', 'css-loader']
    ,
      test: /\.(eot|svg|ttf|woff2?)(\?.+)?$/, loader: 'url-loader'
      query: {limit: 100, name: 'fonts/[name].[ext]'}
    ]
  plugins: [
    new webpack.HotModuleReplacementPlugin()
    new webpack.NamedModulesPlugin()
  ]
