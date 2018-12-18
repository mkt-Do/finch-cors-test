const path = require('path');

exports.default = {
  mode: 'development',
  entry: [ './src/index.js' ],
  output: {
    filename: 'bundle.js',
    path: __dirname + '/dist',
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        use: 'babel-loader',
        exclude: /node_modules/,
      },
    ],
  },
  devServer: {
    contentBase: __dirname + '/dist',
    compress: true,
    port: 9000,
  },
  devtool: 'inline-source-map',
};
