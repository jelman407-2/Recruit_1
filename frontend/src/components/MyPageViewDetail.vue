<template>

    <v-card outlined>
        <v-card-title>
            MyPage # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Email" v-model="item.email" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="EmpId" v-model="item.empId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Name" v-model="item.name" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="JobId" v-model="item.jobId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Contents" v-model="item.contents" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PassYn" v-model="item.passYn" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'MyPageViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/myPages/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

