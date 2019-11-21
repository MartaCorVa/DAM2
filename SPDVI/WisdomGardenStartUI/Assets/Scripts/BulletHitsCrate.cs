using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class BulletHitsCrate : MonoBehaviour
{
    private GameObject gameManagerObject;
    private GameManager gameManager;
    private int contador = 0;
    [SerializeField]
    private Text numberLive;
    private int live = 125;
    [SerializeField]
    private Image liveBar;
    private void OnCollisionEnter(Collision collision)
    {
        if (collision.gameObject.name == "Projectile(Clone)" )
        {
            live -= 25;
            numberLive.text = live + "/125";
            liveBar.rectTransform.localScale = new Vector2(liveBar.rectTransform.localScale.x - 0.2f, liveBar.rectTransform.localScale.y);
            contador++;
            if (contador == 5)
            {
                gameManager.AddToScore(1);
                Destroy(gameObject);
            }           
        }
    }

    // Start is called before the first frame update
    void Start()
    {
        gameManagerObject = GameObject.Find("Game Manager");
        gameManager = gameManagerObject.GetComponent<GameManager>();
        numberLive.text = "125/125";
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
