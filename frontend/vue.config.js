const { defineConfig } = require('@vue/cli-service')
const { proxyRefs } = require('vue')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  devServer: {
    port:8080,
    proxy: {
      '/api': {
        target: 'http://localhost:8081/api',
        ws: true,
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      },
      '/test': {
        target: 'http://localhost:8081/test',
        ws: true,
        changeOrigin: true,
        pathRewrite: {
          '^/test': ''
        }
      },
    }
  }
})