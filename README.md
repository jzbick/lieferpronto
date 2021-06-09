To start this Project you have to have npm installed. And have a mysql server running with a schema named `lieferpronto`.\
To configure the database connection you have to copy the file `src/main/resources/example.application.yml` as `application.yml` and replace
the username and password accordingly.

You may also have to change the database uri.

To start the backend you have to:

```shell
./gradlew bootRun
```

The backend will be available at [localhost:8080](http://localhost:8080).

To start the frontend you have to:

```shell
cd lieferpronto-frontend
npm install
npm run dev
```

The frontend will be available at [localhost:3000](http://localhost:3000).


