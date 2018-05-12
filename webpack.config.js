var path = require('path');

module.exports = {
    entry: './src/main/js/app.js',
    devtool: 'sourcemaps',
    cache: true,
    output: {
        path: __dirname,
        filename: './src/main/resources/static/built/bundle.js'
    },
    module: {
        loaders: [{
            test: /\.js$/,
            loader: 'babel-loader',
            query: {
                presets: ['env', 'react', 'es2015']
            },
            exclude: /node_modules/
        }, {
            test: /\.(png|jpg|gif)$/,
            use: [{
                loader: 'url-loader'
            }]
        }, {
            test: /\.scss$/,
            use: [{
                loader: 'style-loader'
            }, {
                loader: 'css-loader',
                options: {
                    sourceMap: true,
                    module: true,
                    camelCase: true,
                    localIdentName: '[path][name]__[local]--[hash:base64:5]'
                }
            }, {
                loader: 'sass-loader',
                options: {
                    sourceMap: true
                }
            }]
        }]
    }
};
