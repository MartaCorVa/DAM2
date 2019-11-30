using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityStandardAssets.Characters.FirstPerson;

public class ElevateCrate : MonoBehaviour
{
    // Control if the player is on the crate
    private bool isUp = false;
    // Canvas for accessing to the database
    [SerializeField]
    private Canvas menu;
    [SerializeField]
    private GameObject player;
    [SerializeField]
    private GameObject bulletCreator;

    // The Player enter on the collider of the crate
    private void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.name == "FPSController")
        {
            // The player is on the crate
            isUp = true; 
        }
    }

    // The Player exit of the collider of the crate
    private void OnTriggerExit(Collider other)
    {
        if (other.gameObject.name == "FPSController")
        {
            // The player is not on the crate
            isUp = false;
        }
    }

    // Start is called before the first frame update
    void Start()
    {
        // Enable the menu
        menu.enabled = false;
    }

    // Update is called once per frame
    void Update()
    {
        // The player is on the crate so raise up
        if (isUp)
        {
            // The max height
            if (gameObject.transform.position.y <= 5.0f)
            {
                // The crate go up
                gameObject.transform.Translate(Vector3.up * Time.deltaTime);
            } 
        } else
        {
            // The crate go down
            if (gameObject.transform.position.y > 0.63f)
            {
                // The crate goes down
                gameObject.transform.Translate(Vector3.down * Time.deltaTime);
            }
        }
        // The crate is on the max height
        if (gameObject.transform.position.y > 5.0f)
        {
            // If the user press the key K
            if (Input.GetKeyDown(KeyCode.K))
            {
                // Stop the time
                Time.timeScale = 0;
                // Enable the menu (Canvas)
                menu.enabled = true;
                // Disable the player and the bullets
                bulletCreator.GetComponent<BulletCreator>().enabled = false;
                player.GetComponent<FirstPersonController>().enabled = false;
                // Enable Cursor
                Cursor.lockState = CursorLockMode.None;
                Cursor.visible = true;
            }
        }
    }
    public void BackToGame()
    {
        // Restart the time
        Time.timeScale = 1;
        // Disable the menu (Canvas)
        menu.enabled = false;
        menu.GetComponentInChildren<Dropdown>().enabled = false;
        // Enable the player
        bulletCreator.GetComponent<BulletCreator>().enabled = true;
        player.GetComponent<FirstPersonController>().enabled = true;
        // Disable Cursor
        Cursor.lockState = CursorLockMode.Locked;
        Cursor.visible = false;
    }
}
