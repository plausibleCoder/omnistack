import json
import urllib.request

# 1. OUR MOCK DATABASE TOOL
# This simulates a real database table of inventory items.
INVENTORY_DATABASE = {
    "laptop_dell": {"stock": 5, "location": "Aisle 3"},
    "keyboard_mechanical": {"stock": 0, "location": "Aisle 1"},
    "mouse_wireless": {"stock": 12, "location": "Aisle 2"}
}

def check_stock_tool(item_name):
    """This function acts as a physical tool the AI can use."""
    print(f"\n⚙️ [SYSTEM TRIGGER]: Running 'check_stock_tool' for item: {item_name}")
    if item_name in INVENTORY_DATABASE:
        return json.dumps(INVENTORY_DATABASE[item_name])
    return "Item not found in inventory."


# 2. THE CHAT GATEWAY TO YOUR LOCAL QWEN ENGINE
# UPDATE THIS FUNCTION INSIDE YOUR FILE
def talk_to_llm(prompt_text):
    url = "http://localhost:11434/api/generate"
    payload = {
        "model": "qwen2.5-coder:0.5b",
        "prompt": prompt_text,
        "stream": False,
        "options": {
            "temperature": 0.0  # 🎲 FORCE 0.0: Turns off creativity, forces identical answers!
        }
    }
    
    req = urllib.request.Request(
        url, 
        data=json.dumps(payload).encode("utf-8"), 
        headers={"Content-Type": "application/json"}
    )
    
    with urllib.request.urlopen(req) as response:
        result_json = json.loads(response.read().decode("utf-8"))
        return result_json["response"].strip()



# 3. THE MASTER AGENT ENGINE
# UPDATE THIS TO SOLVE THE AI TEXT TYPO BUG
def run_warehouse_agent():
    print("🤖 Warehouse Agent Activated...")
    
    system_rules = (
        "GOAL: Find out if we have any 'laptop_dell' left in stock and where it is located.\n\n"
        "RULES: You must think step-by-step. You have access to ONE tool: [CHECK_STOCK]\n"
        "You must ONLY reply in one of these two exact formats.\n\n"
        "Format option A:\n"
        "THOUGHT: (write what you are planning to do)\n"
        "ACTION: [CHECK_STOCK: item_name]\n\n"
        "Format option B:\n"
        "FINAL ANSWER: (write your final answer here)\n\n"
        "Begin your first turn now."
    )
    
    print("\n--- TURN 1: AI is thinking... ---")
    turn_1_reply = talk_to_llm(system_rules)
    print(turn_1_reply)
    
    # Clean check: Lowercase everything and check if the keyword exists anywhere
    if "action:" in turn_1_reply.lower() and "check_stock" in turn_1_reply.lower():
        target_item = "laptop_dell" 
        tool_data = check_stock_tool(target_item)
        print(f"📦 [TOOL RESULT]: {tool_data}")
        
        print("\n--- TURN 2: AI reads observation and evaluates stopping condition... ---")
        turn_2_prompt = (
            f"{system_rules}\n\n"
            f"You previously outputted:\n{turn_1_reply}\n\n"
            f"OBSERVATION: The tool returned this data: {tool_data}\n"
            f"Now, evaluate this data. Provide your FINAL ANSWER."
        )
        
        turn_2_reply = talk_to_llm(turn_2_prompt)
        print(f"\n{turn_2_reply}")

if __name__ == "__main__":
    print("start of the program")
    run_warehouse_agent()
