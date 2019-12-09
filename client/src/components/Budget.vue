<template>
  <v-container>
    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <h1 class="display-2 font-weight-bold mb-3">ระบบจัดการงบชมรม</h1>
      </v-flex>
    </v-layout>

    <v-row justify="center">
      <v-col cols="4">
        <v-form v-model="valid" ref="form">
          <v-row>
            <v-col cols="10">
              <v-select
                label="Club"
                outlined
                v-model="Budget.clubId"
                :items="club"
                item-text="clubName"
                item-value="clubId"
                :rules="[(v) => !!v || 'Item is required']"
                required
              ></v-select>
            </v-col>
          </v-row>

          <v-row>
            <v-col cols="10">
              <v-select
                label="Club Type"
                outlined
                v-model="Budget.clubtypeId"
                :items="clubtype"
                item-text="clubtypeName"
                item-value="clubtypeId"
                :rules="[(v) => !!v || 'Item is required']"
                required
              ></v-select>
            </v-col>
          </v-row>

       

           <v-row>
            <v-col cols="12" sm="10" md="10">
              <v-text-field label="Budget" v-model="budget" outlined></v-text-field>
            </v-col>
          </v-row>
     
            <v-row>
            <v-col cols="10">
              <v-select
                label="Member Name"
                outlined
                v-model="Budget.memberId"
                :items="member"
                item-text="memberName"
                item-value="memberId"
                :rules="[(v) => !!v || 'Item is required']"
                required
              ></v-select>
            </v-col>
          </v-row>

          <v-row justify="center">
            <v-col cols="12">
              <v-btn @click="savebudget" :class="{ red: !valid, green: valid }">submit</v-btn>
              <v-btn style="margin-left: 50px;" @click="clear">clear</v-btn>
            </v-col>
          </v-row>
          <br />
        </v-form>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import http from "../http-common";

export default {
  name: "Budget",
  data() {
    return {
     Budget: {
        clubId: "",
        clubtypeId: "",  
        memberId: ""
      },
      club: "",
      clubtype: "",
      member: "",
      valid: false,
      foo: 0,
      amount: ""
    };
  },
  methods: {
    /* eslint-disable no-console */
    savebudget() {
      //  @GetMapping("/prescribtion/{symptom}/{unit}/{patientId}/{doctorId}/{medicineId}")
      http
        .get(
          "/budget/" +
            this.amount +
            "/" +
            this.Budget.clubId +
            "/" +
            this.Budget.clubtypeId +
            "/" +
            this.Budget.memberId
        )
        .then(response => {
          console.log("return" + response.data);
          this.amount = "";
          this.Budget.clubId = "";
          this.Budget.clubtypeId = "";
          this.Budget.memberId= "";
          if (response) {
            alert("เพิ่มข้อมูลสำเร็จ");
          }
        })
        .catch(e => {
          console.log(e);
          alert("ไม่สามารถเพิ่มข้อมูลได้");
        });
    },
    // ดึงข้อมูล doctor ใส่ combobox
    getClub() {
      console.log("Doing");
      http
        .get("/clubs")
        .then(response => {
          this.club = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    // ดึงข้อมูล patient ใส่ combobox
    getClubType() {
    
      http
        .get("/clubtypes")
        .then(response => {
          this.clubtype = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
   
    // ดึงข้อมูล medicine ใส่ combobox
    getMember() {
      http
        .get("/members")
        .then(response => {
          this.member = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
      },
        clear() {
        this.$refs.form.reset();
        
      },
       refreshList() {
         this.getClub();
         this.getClubType();
         this.getMember();
      }
      /* eslint-enable no-console */


  },
  mounted() {
    this.getClub();
    this.getClubType();
    this.getMember();
  }
};
</script>