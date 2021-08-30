import "whatwg-fetch";
import * as conf from "../conf/appConf";

async function handle(response) {
    let error = response.status < 200 && response.status >= 300 && response.statusText;
    return await response
        .json()
        .catch(error => {
            console.error(error);
            return { error: "Unexpected error" };
        })
        .then(json => {
            if (!json.error && error) {
                json.error = error;
            }
            if (json.error) {
                console.error(json.error);
            }
            return json;
        });
}

export async function get(url) {
    const response = await fetch(conf.API_PREFIX + url,{
        credentials: 'same-origin'
    });
    return await handle(response);
}

export async function post(url, body) {
    return await call(url, body, "post");
}

export async function purge(url, body) {
    return await call(url, body, "delete");
}

export async function call(url, body, method) {
    const response = await fetch(conf.API_PREFIX + url, {
        method,
        body: JSON.stringify(body),
        credentials: 'same-origin',
        headers: {
            "Content-Type": "application/json",
        },
    });
    return await handle(response);
}