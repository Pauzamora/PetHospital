
<template>
  <div class="split left">
    <div class="centered">
      <a class="navbar-brand float-left" target="_blank">
        <img alt="Logoapp" src="../assets/icon.png" height="65" width="300" />
      </a>
      <form v-on:submit.prevent="processLogInUser">
        <br />
        <h3>Iniciar Sesion</h3>

        <div class="form-group mt-3">
          <input
            type="text"
            class="form-control form-control-lg"
            placeholder="Usuario"
            v-model="user.username"
          />
        </div>
        <br />
        <div class="form-group">
          <input
            type="password"
            class="form-control form-control-lg"
            placeholder="Clave"
            v-model="user.password"
          />
        </div>
        <br />

        <button type="submit" class="btn btn-dark btn-lg btn-block">
          Iniciar Sesion
        </button>
        <p class="forgot-password text-right mt-3">
          ¿Aun no te encuentras registrado?
          <router-link :to="{ name: 'signUp' }">registrate</router-link>
        </p>
        <br />
        <div class="social-icons mt-3"></div>
      </form>
    </div>
  </div>

  <div class="split right">
    <div class="centered"></div>
  </div>
</template>


<script>
import gql from "graphql-tag";

export default {
  name: "LogIn",

  data: function () {
    return {
      user: {
        username: "",
        password: "",
      },
    };
  },

  methods: {
    processLogInUser: async function () {
      await this.$apollo
        .mutate({
          mutation: gql`
            mutation ($credentials: CredentialsInput!) {
              logIn(credentials: $credentials) {
                refresh
                access
              }
            }
          `,
          variables: {
            credentials: this.user,
          },
        })
        .then((result) => {
          let dataLogIn = {
            username: this.user.username,
            token_access: result.data.logIn.access,
            token_refresh: result.data.logIn.refresh,
          };

          this.$emit("completedLogIn", dataLogIn);
        })
        .catch((error) => {
          alert("ERROR 401: Credenciales Incorrectas.");
        });
    },
  },
};
</script>



