# Text-Runner
Bachelor Project - Text-Runner Reimplementation

The main goal of the project is to re-implement the fully automated web-scalable Open Information Extraction(OIE) system called TextRunner.

Its main feature is to extract relations out of a unknown text based on previously observed documents. It consist of three key components: The first one is to use a Self-Supervised Learner, which takes care of classifying the input data into "trustworthy" or not. Second, there is a Single-Pass Extractor that go through the whole text and extracts all of the possible relations. Lastly, the system is using a Redundancy-Based Assessor, used to reduce the relation between the entities as much as possible.

Future work would be to implement different language support, in order to make the system multilingual. Tests and results would be presented.

