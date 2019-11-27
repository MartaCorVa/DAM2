using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityStandardAssets.Characters.FirstPerson;

public class ElevateCrate : MonoBehaviour
{
    // Control if the player is on the crate
    private bool isUp = false;
    [SerializeField]
    private Canvas menu;
    
    private void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.name == "FPSController")
        {
            // The player is on the crate
            isUp = true; 
        } else
        {
            // The player is not on the crate
            isUp = false;
        }
    }
    
    // Start is called before the first frame update
    void Start()
    {
        menu.enabled = false;
    }

    // Update is called once per frame
    void Update()
    {
        // The player is on the crate so raise up
        if (isUp)
        {
            // The max height
            if (gameObject.transform.position.y != 5.0f)
            {
                // The crate go up
                gameObject.transform.Translate(Vector3.up * Time.deltaTime);
            } 
        }
        // The crate is on the max height
        if (gameObject.transform.position.y > 5.0f)
        {
            // Stop the time
            Time.timeScale = 0;
            // If the user press the key K
            if (Input.GetKeyDown(KeyCode.K))
            {
                // Enable the menu (Canvas)
                menu.enabled = true;
                // Disable the player
                GameObject.Find("FPSController").GetComponent<FirstPersonController>().enabled = false;
                // Enable Cursor
                Cursor.lockState = CursorLockMode.None;
                Cursor.visible = true;
            }
        }
    }
}
