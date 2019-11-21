using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class SensorDetect : MonoBehaviour
{
    private GameObject gameManagerObject;
    private GameManager gameManager;
    [SerializeField]
    private Image liveBar;
    [SerializeField]
    private Text numberLive;
    // Start is called before the first frame update
    void Start()
    {
        gameManagerObject = GameObject.Find("Game Manager");
        gameManager = gameManagerObject.GetComponent<GameManager>();
        liveBar.enabled = false;
        numberLive.enabled = false;
    }

    private void OnTriggerEnter(Collider collision)
    {
        if (collision.gameObject.name == "FPSController")
        {
            liveBar.enabled = true;
            // Add the number with live
            numberLive.enabled = true;
        }         
    }

    private void OnTriggerExit(Collider collision)
    {
        if (collision.gameObject.name == "FPSController")
        {
            liveBar.enabled = false;
            numberLive.enabled = false;
        }
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
