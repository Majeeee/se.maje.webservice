import express from "express";
const app = express();
const port = 3000;
app.get("/", (request, response) => {
    response.send("Hello world!");
});
app.listen(port, () => {
    console.log(`Listening to port ${port}`);
});
//# sourceMappingURL=index.js.map