
path = require 'path'
{resolve} = require 'path'
webpack = require 'webpack'

module.exports =
  entry:
    main: './entry/page'
  devServer:
    hot: true
    quiet: true
    contentBase: resolve(__dirname, 'dist')
    publicPath: '/'
  output:
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
