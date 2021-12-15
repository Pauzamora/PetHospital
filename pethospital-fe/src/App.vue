<template>
  <div id="app" class="app">
    <div class="header">
      <nav
        v-if="is_auth"
        class="navbar navbar-light navbar-expand-lg navigation-clean-button"
      >
        <div class="container">
          <img
            src=".\assets\icon.png"
            class="img-fluid"
            width="200"
            heigth="200"
            alt="No disponible"
          />
          <button
            data-bs-toggle="collapse"
            class="navbar-toggler"
            data-bs-target="#navcol-1"
          >
            <span class="visually-hidden">Toggle navigation</span
            ><span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="navbar-nav me-auto">
              <li class="nav-item">
                <router-link class="nav-link" to="Home">Inicio</router-link>
              </li>
              <li class="nav-item">
                <router-link class="nav-link" to="Home"
                  >Ingresa tu Paciente</router-link
                >
              </li>
              <li class="nav-item">
                <router-link class="nav-link" to="Home"
                  >Ver Pacientes</router-link
                >
              </li>
            </ul>
            <span class="navbar-text actions">
              <a
                class="btn btn-light action-button"
                role="button"
                v-on:click="logOut"
                >Cerrar sesión</a
              ></span
            >
          </div>
        </div>
      </nav>
    </div>

    <div class="main-component">
      <router-view
        v-on:completedLogIn="completedLogIn"
        v-on:completedSignUp="completedSignUp"
        v-on:logOut="logOut"
      >
      </router-view>
    </div>
  </div>
</template>


<script>
export default {
  name: "App",

  computed: {
    is_auth: {
      get: function () {
        return this.$route.meta.requiresAuth;
      },
      set: function () {},
    },
  },

  methods: {
    loadLogIn: function () {
      this.$router.push({ name: "logIn" });
    },

    loadSignUp: function () {
      this.$router.push({ name: "signUp" });
    },

    completedLogIn: function (data) {
      localStorage.setItem("username", data.username);
      localStorage.setItem("token_access", data.token_access);
      localStorage.setItem("token_refresh", data.token_refresh);

      this.loadHome();
    },

    completedSignUp: function (data) {
      this.completedLogIn(data);
    },

    loadHome: function () {
      this.$router.push({ name: "home" });
    },

    logOut: function () {
      localStorage.clear();
      this.loadLogIn();
    },
  },
};
</script>


<style>
.navigation-clean-button {
  background: #fff;
  padding-top: 0.75rem;
  padding-bottom: 0.75rem;
  color: #333;
  border-radius: 0;
  box-shadow: none;
  border: none;
  margin-bottom: 0;
}

@media (min-width: 768px) {
  .navigation-clean-button {
    padding-top: 1rem;
    padding-bottom: 1rem;
  }
}

.navigation-clean-button .navbar-brand {
  font-weight: bold;
  color: inherit;
}

.navigation-clean-button .navbar-brand:hover {
  color: #222;
}

.navigation-clean-button .navbar-toggler {
  border-color: #ddd;
}

.navigation-clean-button .navbar-toggler:hover,
.navigation-clean-button .navbar-toggler:focus {
  background: none;
}

.navigation-clean-button .navbar-toggler {
  color: #888;
}

.navigation-clean-button .navbar-nav a.active,
.navigation-clean-button .navbar-nav > .show > a {
  background: none;
  box-shadow: none;
}

.navigation-clean-button.navbar-light .navbar-nav a.active,
.navigation-clean-button.navbar-light .navbar-nav a.active:focus,
.navigation-clean-button.navbar-light .navbar-nav a.active:hover {
  color: #8f8f8f;
  box-shadow: none;
  background: none;
  pointer-events: none;
}

.navigation-clean-button.navbar .navbar-nav .nav-link {
  padding-left: 18px;
  padding-right: 18px;
}

.navigation-clean-button.navbar-light .navbar-nav .nav-link {
  color: #465765;
}

.navigation-clean-button.navbar-light .navbar-nav,
.navigation-clean-button.navbar-light .navbar-nav {
  color: #494949 !important;
  background-color: transparent;
}
.nav-link:hover {
  color: #f5f5f5 !important;
  background-color: transparent;
}
.navigation-clean-button .navbar-nav > li > .dropdown-menu {
  margin-top: -5px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  background-color: #fff;
  border-radius: 2px;
}

.navigation-clean-button .dropdown-menu .dropdown-item:focus,
.navigation-clean-button .dropdown-menu .dropdown-item {
  line-height: 2;
  font-size: 14px;
  color: #37434d;
}

.navigation-clean-button .dropdown-menu .dropdown-item:focus,
.navigation-clean-button .dropdown-menu .dropdown-item:hover {
  background: #eee;
  color: inherit;
}

.navigation-clean-button .actions .login {
  margin-right: 1rem;
  text-decoration: none;
  color: #465765;
}

.navigation-clean-button .navbar-text .action-button,
.navigation-clean-button .navbar-text .action-button:active,
.navigation-clean-button .navbar-text .action-button:hover {
  background: #1892f2;
  border-radius: 20px;
  font-size: inherit;
  color: #fff;
  box-shadow: none;
  border: none;
  text-shadow: none;
  padding: 0.5rem 1rem;
  transition: background-color 0.25s;
  font-size: inherit;
}

.navigation-clean-button .navbar-text .action-button:hover {
  background: #1892f2;
}
.navigation-clean-button .navbar-nav > li:hover {
  border-radius: 20px;
  background: #1692f1;
}
</style>
