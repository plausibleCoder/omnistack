import os
import sys

# 1. We tell Spark EXACTLY which Python app to talk to
os.environ['PYSPARK_PYTHON'] = sys.executable
os.environ['PYSPARK_DRIVER_PYTHON'] = sys.executable

from pyspark.sql import SparkSession

# 2. Start the Spark Boss
spark = SparkSession.builder \
    .appName("LegoBrickCounter") \
    .master("local[*]") \
    .getOrCreate()

# 3. Create our list of Legos
lego_data = [
    ("Red", "Small"),
    ("Blue", "Medium"),
    ("Red", "Large"),
    ("Green", "Small"),
    ("Red", "Medium")
]

# 4. Column names
columns = ["Color", "Size"]

# 5. Turn it into a table and SHOW IT!
lego_table = spark.createDataFrame(lego_data, schema=columns)
lego_table.show()
