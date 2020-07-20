var webpack = require('webpack')
var path = require("path");
var fs = require('fs');

module.exports = {
    runtimeCompiler: true,
    outputDir: path.resolve(__dirname, "../web/src/main/resources/public"),
    parallel: true,
    devServer: {
        port: 8000,
        host: 'localhost',
        proxy: {
            '/api': {
                target: 'http://localhost:8080/',
                changeOrigin: true,
            },
        }
    }
}