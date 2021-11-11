const headers = {
	'Accept': 'application/json',
	'Content-Type': 'application/json; charset=utf-8'
}

export const getFetchData = (url) => {
	return fetch(url, { method: "GET" , headers })
		.then(res => Promise.all([res, res.json()]))
		.then(([response, json]) => {
			if(!response.ok){
				throw new Error(JSON.stringify(json))
			}
			return json
		})
}

export const postFetchData = (url, data) => {
	return fetch(url, { method: "POST" , headers, body: JSON.stringify(data) })
		.then(res => Promise.all([res, res.json()]))
		.then(([response, json]) => {
			if(!response.ok){
				throw new Error(JSON.stringify(json))
			}
			return json
		})
		.catch(err => {
			throw JSON.parse(err.message)
		})
}

export const patchFetchData = (url, data) => {
	return fetch(url, { method: "PATCH" , headers, body: JSON.stringify(data) })
		.then(res => Promise.all([res, res.json()]))
		.then(([response, json]) => {
			if(!response.ok){
				throw new Error(JSON.stringify(json))
			}
			return json
		})
}