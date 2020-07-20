import Vue from 'vue'
// import App from './App.vue'
import moment from 'moment'
import PostMessage from "./components/PostMessage";
import LoadMessage from "./components/LoadMessage";

Vue.config.productionTip = false

Vue.filter('BuyCurrency', function (value) {
  if (!value) return ''
  value = value.toString()
  return value.substring(0,3)
})

Vue.filter('SellCurrency', function (value) {
  if (!value) return ''
  value = value.toString()
  return value.substring(4,7)
})

Vue.filter('formatTime', function(value) {
  if (!value) return ''
  return moment(value).format('DD-MMM-YY hh:mm:ss')
})

let routes = {
  '/post': PostMessage,
  '/load': LoadMessage
}

new Vue({
  el: '#app',
  data: {
    currentRoute: window.location.pathname
  },
  computed: {
    ViewComponent () {
      return routes[this.currentRoute] || undefined
    }
  },
  render (h) { return h(this.ViewComponent) }
})
