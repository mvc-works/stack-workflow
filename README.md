
Stack Workflow
----

Personal project template based on Respo, Boot, ClojureScript, Cirru Sepal, shadow-cljs...

### Usage

Compilation steps:

```text
Cirru   -> ClojureScript  -> JavaScript   -> App
ir.edn     src/              target/         dist/
```

Dependencies:

```bash
# Node.js , JVM
npm i -g stack-editor
yarn
```

To run in development:

```bash
stack-editor
# another tty
yarn cljs-browser
# another tty
yarn dev
# open localhost:8080
```

To build:

```bash
yarn build
# outputs to dist/
```

Assets would be like: http://repo.tiye.me/mvc-works/stack-workflow/

### Workflow

Workflow https://github.com/mvc-works/stack-workflow

Package jar file and install locally:

```bash
boot build
```

Package jar file and send to Clojars:

```bash
boot deploy
```

Get ClojureScript code:

```bash
op=compile stack-editor
```

### License

MIT
