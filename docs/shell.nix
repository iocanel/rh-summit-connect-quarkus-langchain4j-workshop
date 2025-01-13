{ pkgs ? import <nixpkgs> {} }:

pkgs.mkShell {
  name = "pipenv-environment";

  # Add pipenv to the environment
  buildInputs = with pkgs; [
    python3
    pipenv
    plantuml  # Include any additional tools like plantuml
  ];

  shellHook = ''
    echo "Welcome to the Pipenv environment!"
    pipenv install --dev
  '';
}
