<template>
  <section class="article-list">
    <section class="article-list">
      <div class="container" onselectstart="return false;">
        <div class="intro">
          <h2 class="text-center">Bienvenid@ Doc!</h2>
          <p
            class="text-center"
            style="font-size: 50px; margin: 0px 0px 50px 0px"
          >
            {{ userDetailById.name }}
          </p>
        </div>
      </div>
    </section>
    <div class="container">
      <div class="container-fluid">
        <div class="row articles">
          <div
            class="col-sm-6 col-md-4 item"
            a
            style="background-color: #fafafa"
            href="#"
          >
            <h3 class="name">Ingresa tu paciente</h3>
            <p class="description">Aca podras ingresar tu paciente</p>
            <router-link class="action" to="Home"
              ><i class="fa fa-arrow-circle-right"></i
            ></router-link>
            <img
              src="..\assets\dog_230497594.jpg"
              class="img-fluid"
              width="200"
              heigth="200"
              alt="No disponible"
            />
          </div>

          <div
            class="col-sm-6 col-md-4 item"
            a
            style="background-color: #eeeeee"
            href="#"
          >
            <h3 class="name">Ver pacientes</h3>
            <p class="description">Revisa tus pacientes registrados</p>
            <router-link class="action" to="Home"
              ><i class="fa fa-arrow-circle-right"></i
            ></router-link>
            <img
              src="..\assets\Pets.jpg"
              class="img-fluid"
              width="250"
              heigth="250"
              alt="No disponible"
            />
          </div>

          <!--HISTORIAL-->

          <div
            class="col-sm-6 col-md-4 item"
            a
            style="background-color: #fafafa"
            href="#"
          >
            <h3 class="name">Buscar Paciente</h3>
            <p class="description">
              Aca podremos buscar un paciente en especifico
            </p>
            <router-link class="action" to="Home"
              ><i class="fa fa-arrow-circle-right"></i
            ></router-link>
            <img
              src="..\assets\gatSearch.jpg"
              class="img-fluid"
              width="200"
              heigth="200"
              alt="No disponible"
            />
          </div>
        </div>
      </div>
    </div>
  </section>
</template>


<script>
import gql from "graphql-tag";
import jwt_decode from "jwt-decode";

export default {
  name: "Home",

  data: function () {
    return {
      userId: jwt_decode(localStorage.getItem("token_refresh")).user_id,
      userDetailById: {
        username: "",
        name: "",
        email: "",
      },
    };
  },

  apollo: {
    userDetailById: {
      query: gql`
        query ($userId: Int!) {
          userDetailById(userId: $userId) {
            username
            name
            email
          }
        }
      `,
      variables() {
        return {
          userId: this.userId,
        };
      },
    },
  },
};
</script>


<style >
.article-list {
  color: #313437;
  background-color: #fff;
}

.article-list p {
  color: #7d8285;
}

.article-list h2 {
  font-weight: bold;
  margin-bottom: 40px;
  padding-top: 40px;
  color: inherit;
}

@media (max-width: 767px) {
  .article-list h2 {
    margin-bottom: 25px;
    padding-top: 25px;
    font-size: 24px;
  }
}

.article-list .intro {
  font-size: 16px;
  max-width: 500px;
  margin: 0 auto;
}

.article-list .intro p {
  margin-bottom: 0;
}

.article-list .articles {
  padding-bottom: 40px;
}

.article-list .item {
  padding-top: 50px;
  min-height: 425px;
  text-align: center;
}

.article-list .item .name {
  font-weight: bold;
  font-size: 16px;
  margin-top: 20px;
  color: inherit;
}

.article-list .item .description {
  font-size: 14px;
  margin-top: 15px;
  margin-bottom: 0;
}

.article-list .item .action {
  font-size: 24px;
  width: 24px;
  margin: 22px auto 0;
  line-height: 1;
  display: block;
  color: #4f86c3;
  opacity: 0.85;
  transition: opacity 0.2s;
  text-decoration: none;
}

.article-list .item .action:hover {
  opacity: 1;
}
</style>
    