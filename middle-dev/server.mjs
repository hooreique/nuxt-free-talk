import {log} from "node:console";
import express from "express";
import {createProxyMiddleware} from "http-proxy-middleware";

const app = express();

app.use(
    "/api",
    createProxyMiddleware({
        target: "http://127.0.0.1:8080",
    })
);

app.use(
    "/",
    createProxyMiddleware({
        target: "http://127.0.0.1:3000",
    })
);

app.listen(3333, () => {
    log("Proxy server is running on port 3333");
});
