# md-word.py

import pypandoc
import os

# --- STEP 1: EDIT THIS LINE ---
# Provide the FULL, absolute path to your input Markdown file.
# IMPORTANT: Use forward slashes (/) or start the string with 'r' to avoid path errors.
#
# Choose ONE of the following formats:

# Option A: Using forward slashes (Recommended)
input_md_file_path = "C:/Karthik/LEARNING/Design Patterns/Design_patterns.md"

# Option B: Using a raw string with backslashes
# input_md_file_path = r"C:\Karthik\LEARNING\Design Patterns\Design_patterns.md"


# --- NO MORE EDITS NEEDED BELOW THIS LINE ---

try:
    # Check if the file you specified actually exists
    if not os.path.exists(input_md_file_path):
        raise FileNotFoundError(f"The input file could not be found at the path you specified: {input_md_file_path}")

    # Automatically determine the output filename and location (same as input)
    base_name = os.path.basename(input_md_file_path)
    file_name_without_ext = os.path.splitext(base_name)[0]
    output_directory = os.path.dirname(input_md_file_path)
    output_docx_file = os.path.join(output_directory, f"{file_name_without_ext}.docx")

    print(f"Input file:  '{input_md_file_path}'")
    print(f"Output file: '{output_docx_file}'")
    print("\nConverting...")

    pypandoc.convert_file(
        input_md_file_path,
        'docx',
        outputfile=output_docx_file
    )

    print("\nConversion successful!")
    print(f"File saved in the same folder as your markdown file.")

except FileNotFoundError as fnf_error:
    print(f"\n--- ERROR ---")
    print(fnf_error)
except Exception as e:
    print("\n--- An error occurred during conversion ---")
    print("Please ensure Pandoc is installed and accessible in your system's PATH.")
    print(f"Error details: {e}")

