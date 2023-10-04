import datetime
from datetime import datetime
# Configuration file for the Sphinx documentation builder.
#
# For the full list of built-in configuration values, see the documentation:
# https://www.sphinx-doc.org/en/master/usage/configuration.html

# -- Project information -----------------------------------------------------
# https://www.sphinx-doc.org/en/master/usage/configuration.html#project-information

project = 'Dev Note\'s'
copyright = f'2022-{datetime.now().year}, Kiran Marturu'
author = 'Kiran Marturu'

# -- General configuration ---------------------------------------------------
# https://www.sphinx-doc.org/en/master/usage/configuration.html#general-configuration

extensions = [
    'myst_parser',
    'sphinx_inline_tabs',
    'sphinx_design',
    'sphinxcontrib.katex',
    'sphinx_copybutton'
]

myst_enable_extensions = ["colon_fence", "dollarmath"]

templates_path = ['_templates']
exclude_patterns = []

# -- Options for HTML output -------------------------------------------------
# https://www.sphinx-doc.org/en/master/usage/configuration.html#options-for-html-output

html_theme = 'furo'
html_title = 'Dev Note\'s'
html_static_path = ['_static']

html_css_files = [
    'css/custom.css',
]