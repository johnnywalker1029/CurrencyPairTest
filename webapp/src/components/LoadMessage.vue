<template>
    <div>
        <button v-on:click="refresh">Refresh</button>
        <table>
            <thead>
                <th>
                    <label>User Id</label>
                </th>
                <th>
                    <label>Currency To</label>
                </th>
                <th>
                    <label>Amount To</label>
                </th>
                <th>
                    <label>Currency From</label>
                </th>
                <th>
                    <label>Amount From</label>
                </th>
                <th>
                    <label>Original Country</label>
                </th>
                <th>
                    <label>Proceeded Time</label>
                </th>
            </thead>
            <tbody>
                <tr v-for="item in trades" :key="item.id">
                    <td>{{item.userId}}</td>
                    <td>{{item.currPair|BuyCurrency}}</td>
                    <td>{{item.amt}}</td>
                    <td>{{item.currPair|SellCurrency}}</td>
                    <td>{{item.amt/item.rate}}</td>
                    <td>{{item.originCountry}}</td>
                    <td>{{item.placedTime|formatTime}}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    import axios from 'axios';

    export default {
        mounted: function(){
            this.refresh()
        },
        data: () => {
            return {
                trades:[]
            }
        }, methods: {
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
    label {
        width: 120px;
    }

    input {
        width: 80px;
    }

    table tr td {
        border: 1px solid;
    }
</style>