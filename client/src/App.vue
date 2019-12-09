<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title class="headline text-uppercase">
        <span>System</span>
        <span class="font-weight-light"> Analysis and Design</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
     
    </v-app-bar>

    <v-content>
      <!-- <VideoRental/> -->
      <router-view />
    </v-content>
  </v-app>
</template>

<script>

export default {
  name: 'App',
 
};
</script>
