# waste-organisations-perf-tests

A JMeter based test runner for the CDP Platform.

- [Licence](#licence)
  - [About the licence](#about-the-licence)

## Build

Test suites are built automatically by the [.github/workflows/publish.yml](.github/workflows/publish.yml) action whenever a change are committed to the `main` branch.
A successful build results in a Docker container that is capable of running your tests on the CDP Platform and publishing the results to the CDP Portal.

## Run

The performance test suites are designed to be run from the CDP Portal.
The CDP Platform runs test suites in much the same way it runs any other service, it takes a docker image and runs it as an ECS task, automatically provisioning infrastructure as required.

## Local Running

### Using the Entrypoint Script

The repository provides an entrypoint script for running JMeter tests on the command line.

**Important**: The script sources `env.sh` automatically, so you must set all environment variables in the `env.sh` file rather than exporting them in the command line.

```bash
# Run single test (uses TEST_SCENARIO from env.sh)
./entrypoint.sh

# Run all tests (set TEST_SCENARIO=all in env.sh)
./entrypoint.sh
```

You will need jMeter installed locally. Alternatively, run with Docker instead.

### Using Docker

The performance tests can be run within Docker.

Running against a local service that is not already deployed to CDP is currently not supported but it could be with some further changes. We would need an IDP to get an access token for example.

**Important**: Configure the service environment variables as per template file [./compose/perf-tests.env.template](./compose/perf-tests.env.template) and build. The values for the env file are the same as those used in `env.sh`.

Build, if needed, separately.

```bash
docker compose build --no-cache perf-tests
```

Run the following, which will start the tests automatically against the environment you have configured.

```bash
docker compose up --build
```

Once run, observe the results by visiting http://localhost:8080 to see the jMeter report.

You can also access the results locally in the ./results folder once execution is complete.

## Licence

THIS INFORMATION IS LICENSED UNDER THE CONDITIONS OF THE OPEN GOVERNMENT LICENCE found at:

<http://www.nationalarchives.gov.uk/doc/open-government-licence/version/3>

The following attribution statement MUST be cited in your products and applications when using this information.

> Contains public sector information licensed under the Open Government licence v3

### About the licence

The Open Government Licence (OGL) was developed by the Controller of Her Majesty's Stationery Office (HMSO) to enable
information providers in the public sector to license the use and re-use of their information under a common open
licence.

It is designed to encourage use and re-use of information freely and flexibly, with only a few conditions.
