***********
Development
***********

Install
=======

Build from source
-----------------

* Import as Maven project
* Generate the jar file

  .. code-block:: bash

    mvn package

* Copy the jar file ``target/kafka-connect-datagen-$version.jar`` to a Kafka Connect worker's classpath

Docs
====

Update connector configs
------------------------

Connector configurations are defined as ``ConfigDef`` objects. To convert the code-level definitions to documentation
files, run

.. code-block:: bash

  mvn clean compile test -Pgenerate-config-docs


Update user guide
-----------------

We write user guide in `ReStructuredText`_ and use `Sphinx`_ to generate static HTML pages.

* Install `Sphinx`_ in a Python virtualenv
* Activate the virtualenv and run

  .. code-block:: bash

    sphinx-build -b html docs/ docs/_build

* Open ``docs/_build/index.html`` in browser to view the updated version.

.. _ReStructuredText: http://www.sphinx-doc.org/en/master/usage/restructuredtext/
.. _Sphinx: http://www.sphinx-doc.org/
