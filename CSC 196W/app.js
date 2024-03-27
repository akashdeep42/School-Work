'use strict';

const express = require('express');
const app = express();

const port = 3000;

// Exercise 1
app.use(express.json());
app.get("/math/circle/:r", (req, res) => {
  if (req.params.r && !isNaN(req.params.r)) {
    let x = Number(req.params.r);
    let circumference = 2 * Math.PI * x;
    let area = Math.PI * x * x;
    res.send({ area, circumference });
  }
});

// Exercise 2
app.get("/", (req, res) => {
  res.send("Hello World!");
});

app.get("/hello/name", (req, res) => {
  if (req.query.last === undefined || req.query.first === undefined) {
    res.status(400).send("Missing Required GET parameters: first, last");
  } else {
    res.send('Hello ' + req.query.first + ' ' + req.query.last);
  }
});

const PORT = process.env.PORT || 8000;
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});