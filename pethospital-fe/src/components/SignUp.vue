<template>
  <div class="split left">
    <div class="centeredSign">
      <a class="navbar-brand float-left" target="_blank">
        <img alt="Logoapp" src="../assets/icon.png" height="65" width="300" />
      </a>
      <form v-on:submit.prevent="processSignUp">
        <br />
        <h3>Registrarse</h3>
        <div class="form-group mt-3">
          <input
            type="text"
            class="form-control form-control-lg"
            v-model="user.documentType"
            placeholder="Tipo Documento"
          />
        </div>
        <br />
        <div class="form-group">
          <input
            type="number"
            class="form-control form-control-lg"
            v-model="user.document"
            placeholder="Documento"
          />
        </div>
        <br />

        <div class="form-group">
          <input
            type="text"
            class="form-control form-control-lg"
            v-model="user.name"
            placeholder="Nombre"
          />
        </div>
        <br />
        <div class="form-group">
          <input
            type="email"
            class="form-control form-control-lg"
            v-model="user.email"
            placeholder="Correo Electronico"
          />
        </div>
        <br />

        <div class="form-group">
          <input
            type="number"
            class="form-control form-control-lg"
            v-model="user.phone"
            placeholder="Telefono"
          />
        </div>
        <br />
        <div class="form-group">
          <input
            type="text"
            class="form-control form-control-lg"
            v-model="user.username"
            placeholder="Usuario"
          />
        </div>
        <br />
        <div class="form-group">
          <input
            type="password"
            class="form-control form-control-lg"
            v-model="user.password"
            placeholder="Clave"
          />
        </div>
        <br />

        <button type="submit" class="btn btn-dark btn-lg btn-block">
          Crear Cuenta
        </button>

        <p class="forgot-password text-right mt-3">
          ¿ya estas registrado
          <router-link :to="{ name: 'logIn' }">Inicia sesion?</router-link>
        </p>
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
  name: "SignUp",

  data: function () {
    return {
      user: {
        username: "",
        password: "",
        name: "",
        documentType: "",
        document: 0,
        email: "",
        phone: 0,
      },
    };
  },

  methods: {
    processSignUp: async function () {
      await this.$apollo
        .mutate({
          mutation: gql`
            mutation ($userInput: SignUpInput!) {
              signUpUser(userInput: $userInput) {
                refresh
                access
              }
            }
          `,
          variables: {
            userInput: this.user,
          },
        })
        .then((result) => {
          let dataLogIn = {
            username: this.user.username,
            token_access: result.data.signUpUser.access,
            token_refresh: result.data.signUpUser.refresh,
          };

          this.$emit("completedSignUp", dataLogIn);
        })
        .catch((error) => {
          alert("ERROR: Fallo en el registro.");
        });
    },
  },
};
</script>



