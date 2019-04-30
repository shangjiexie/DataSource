<template>
  <div id="app">
    <app-Header></app-Header>
    <div>
      <router-view/>
    </div>
  </div>
</template>

<script>
import Header from "./components/Header";
import IndexPage from "./components/Index";
import axios from "axios";
import qs from "qs";

export default {
  name: "App",
  components: {
    appHeader: Header,
    appIndex: IndexPage
  }
};
</script>

<style>
</style>
