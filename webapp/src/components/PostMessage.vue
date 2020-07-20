<template>
    <form>
        <div>
            <label>User Id:</label>
            <input v-model="trade.userId" type="input"/>
        </div>
        <div>
            <label>Currency From:</label>
            <select v-model="sell_curr">
                <option v-for="currency in currencies" :key="currency">{{currency}}</option>
            </select>
            <input v-model="sell_amt" type="number" step="any" @blur="triggerBySellAmt"/>
        </div>
        <div>
            <label>Currency To:</label>
            <select v-model="buy_curr">
                <option v-for="currency in currencies" :key="currency">{{currency}}</option>
            </select>
            <input v-model="buy_amt" type="number" step="any" @blur="triggerByBuyAmt"/>
        </div>
        <div>
            <label>Rate</label>
            <input type="input" v-model="trade.rate" @blur="triggerByRate"/>
        </div>
        <div>
            <label>Original Country:</label>
            <select v-model="trade.originCountry">
                <option v-for="country in countries" :key="country">{{country}}</option>
            </select>
        </div>
        <div>
            <label>Time Placed:</label>
            <input class="datetime" type="datetime-local" v-model="trade.placedTime" step="1"/>
        </div>
        <button v-on:click="post_message">Post Message</button>
    </form>
</template>

<script>
    import axios from 'axios';
    import moment from 'moment';

    export default {
        props: {
        },
        data: () => {
            return {
                countries:[],
                currencies:[],
                trade: {
                    userId: "Superman",
                    amt: null,
                    originCountry: "HK",
                    rate: 0.7471,
                    placedTime: moment()
                },
                buy_curr: "GBP",
                sell_curr: "EUR",
                buy_amt: 747.1,
                sell_amt: 1000,
            }
        },
        mounted: function(){
            let self = this;
            axios.get('/api/static/countries').
            then(function(response){
                self.countries = response.data
            }).catch(function(error){
                alert(error)
            })
            axios.get('/api/static/currencies').
            then(function(response){
                self.currencies = response.data
            }).catch(function(error){
                alert(error)
            })
            this.refresh()
        },
        filters: {
          currency: function (value) {
            if (!value) return ''
            value = value.toString()
            return value.charAt(0).toUpperCase() + value.slice(1)
          }
        },
        methods: {
            triggerBySellAmt: function() {
                console.log(this.buy_amt + ' ' + this.sell_amt + ' ' + this.trade.rate)
                this.buy_amt = this.trade.rate*this.sell_amt
            },
            triggerByBuyAmt: function() {
                console.log(this.buy_amt + ' ' + this.sell_amt + ' ' + this.trade.rate)
                this.sell_amt = this.buy_amt/this.trade.rate
            },
            triggerByRate: function() {
                console.log(this.buy_amt + ' ' + this.sell_amt + ' ' + this.trade.rate)
                this.buy_amt = this.trade.rate*this.sell_amt
            },
            post_message: function() {
                let self = this
                this.trade.currPair = this.buy_curr + "/" + this.sell_curr
                this.trade.amt = this.buy_amt
                this.trade.placedTime = moment(this.trade.placedTime).format('YYYY-MM-DD hh:mm:ss')
                axios.post('/api/post_trade',this.trade).
                then(function(response){
                    alert("Post Successed!" + response.data)
                    self.refresh()
                }).catch(function(error){
                    alert("Failed: " + error)
                })

            },
            refresh: function() {
                let self = this;
                axios.get('/api/trades').
                then(function(response){
                    self.trades = response.data
                }).catch(function(error){
                    alert("Failed: " + error)
                })
            }
        }
    };
</script>

<style scoped>
    form {
        width: 100%;
        display: flex;
        flex: 1 1 100%;
    }

    label {
        width: 120px;
    }

    input {
        width: 80px;
    }

    table tr td {
        border: 1px solid;
    }

    .datetime {
        width: 300px
    }
</style>