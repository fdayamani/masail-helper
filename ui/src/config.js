const dev = {
    BASE_URL: "http://localhost:8080"
}

const prod = {
    BASE_URL: "https://masail-helper-ltqs6mfj7q-ue.a.run.app/"
}

const config = process.env.REACT_APP_STAGE === 'production'
  ? prod
  : dev;

export default config;