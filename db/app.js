const express = require("express");
const app = express();
const path = require("path");

app.set("view engine", "ejs");
app.set("views", path.join(__dirname, "views"));

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(express.static(path.join(__dirname, "public")));

const userModel = require("./userModel");

app.get("/", (req, res) => {
  res.render("index");
});

app.listen(3000, () => {
  console.log("running on port 3000");
});
